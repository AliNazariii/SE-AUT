<?php

namespace App\Http\Controllers;

use App\Comment;
use App\Custom\Utils;
use App\Custom\Validators;
use App\Item;
use Illuminate\Http\Request;
use JWTAuth;

class CommentController extends Controller {
    protected $user;
    public function __construct() {
        $this->user = JWTAuth::parseToken()->authenticate();
    }

    public function index($item_id){
        $comments = $this->user->isCustomer() ?
            Item::find($item_id)->comments()->get(['id', 'message', 'approved', 'item_id'])
            : Comment::all();
        return Utils::makeJsonResponse(true, $comments);
    }

    public function show($item_id,$id){
        return Utils::makeJsonResponse(true, Comment::find($id));
    }

    public function store(Request $request, $item_id) {
        $validator = Validators::commentStoreValidator($request);

        if($validator->fails()) {
            return Utils::makeJsonResponse(false, $validator->errors());
        }

        $comment = new Comment();
        $comment->item_id = $item_id;
        $comment->message = $request->message;
        $comment->approved = false;

        try{
            $comment->save();
            return Utils::makeJsonResponse(true, $comment);
        } catch (\Exception $exception){
            return Utils::makeJsonResponse(false, $exception->getMessage());
        }

    }

}
