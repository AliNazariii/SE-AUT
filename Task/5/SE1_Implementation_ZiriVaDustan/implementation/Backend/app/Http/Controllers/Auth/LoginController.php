<?php

namespace App\Http\Controllers\Auth;

use App\Custom\Utils;
use App\Custom\Validators;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class LoginController extends Controller {
  public function login(Request $request) {
      try {
          $validator = Validators::loginValidator($request);

          if ($validator->fails()) {
              return Utils::makeJsonResponse(false, $validator->errors());
          }


          $credentials = \request(['username', 'password']);
          if ($token = auth()->attempt($credentials)) {
              return Utils::makeJsonResponse(true, $token);
          } else {
              return Utils::makeJsonResponse(false, null);
          }
      } catch (\Exception $exception) {
          return Utils::makeJsonResponse(false, $exception);
      }
  }
}
