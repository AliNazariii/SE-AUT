<?php
/**
 * Created by PhpStorm.
 * User: Amas
 * Date: 2/3/2019
 * Time: 12:36 PM
 */

namespace App\Custom;



use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class Validators {
    public static function loginValidator(Request $request){
        $rules = array(
            'username' => 'required',
            'password' => 'required|min:8',
        );
        $validator = Validator::make($request->all(),$rules);

        return $validator;
    }
    public static function registerValidator(Request $request){
        $rules = array(
            'username' => 'required|unique:users',
            'password' => 'required|min:8',
        );
        $validator = Validator::make($request->all(),$rules);

        return $validator;
    }
    public static function itemStoreValidator(Request $request){
        $rules = array(
            'category' => 'required',
            'name' => 'required',
            'price' => 'required|numeric',
            'count' => 'required|numeric',
            'available' => 'required|boolean',
            'description' => 'required',

        );
        $validator = Validator::make($request->all(),$rules);

        return $validator;
    }

    public static function commentStoreValidator(Request $request){
        $rules = array(
            'message' => 'required',
        );
        $validator = Validator::make($request->all(),$rules);

        return $validator;
    }
    public static function orderStoreValidator(Request $request){
        $rules = array(
            'state' => 'required',
            'description' => 'required',
            'totalCost' => 'required',
        );
        $validator = Validator::make($request->all(),$rules);

        return $validator;
    }
}