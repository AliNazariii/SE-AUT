<?php

namespace App\Http\Controllers;

use App\Custom\Utils;
use App\Custom\Validators;
use App\Order;
use Illuminate\Http\Request;
use JWTAuth;

class OrderController extends Controller {

    protected $user;
    public function __construct() {
        $this->user = JWTAuth::parseToken()->authenticate();
    }

    public function index() {
        $orders = $this->user->isCustomer() ?
            $this->user->orders()->get(['items','id', 'state', 'description', 'totalCost'])
            : Order::all();
        return Utils::makeJsonResponse(true, $orders);
    }

    public function show($id) {
        return Utils::makeJsonResponse(
            true,
            Order::find($id)
        );
    }

    public function store(Request $request) {
        $validator = Validators::orderStoreValidator($request);
        if($validator->fails()) {
            return Utils::makeJsonResponse(false, $validator->errors());
        }
        $order = new Order();
        $order->items = $request->items;
        $order->user_id = $this->user->id;
        $order->state = $request->state;
        $order->description = $request->description;
        $order->totalCost = $request->totalCost;

        try{
            $order->save();
            return Utils::makeJsonResponse(true, $order);
        } catch(\Exception $exception) {
            return Utils::makeJsonResponse(false, $exception->getMessage());
        }
    }

    public function update() {

    }

    public function delete($id) {
        try {
            $order = Order::find($id);
            $order->delete();
            return Utils::makeJsonResponse(true, null);
        } catch (\Exception $exception) {
            return Utils::makeJsonResponse(false, $exception->getMessage());
        }
    }
}
