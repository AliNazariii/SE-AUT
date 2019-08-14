<?php

namespace App\Custom;

class Utils {

    public static function makeJsonResponse($success, $data){
        return response()->json([
            'success' => $success,
            'data' => $data,
//            'code' => $code
        ]);
    }
}