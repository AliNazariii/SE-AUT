<?php

namespace App\Exceptions;

use App\Custom\Utils;
use Exception;
use Illuminate\Foundation\Exceptions\Handler as ExceptionHandler;
use Illuminate\Http\Exceptions\ThrottleRequestsException;
use Symfony\Component\HttpKernel\Exception\UnauthorizedHttpException;
use Tymon\JWTAuth\Exceptions\JWTException;
use Tymon\JWTAuth\Exceptions\TokenExpiredException;
use Tymon\JWTAuth\Exceptions\TokenInvalidException;

class Handler extends ExceptionHandler
{
    /**
     * A list of the exception types that are not reported.
     *
     * @var array
     */
    protected $dontReport = [
        //
    ];

    /**
     * A list of the inputs that are never flashed for validation exceptions.
     *
     * @var array
     */
    protected $dontFlash = [
        'password',
        'password_confirmation',
    ];

    /**
     * Report or log an exception.
     *
     * @param  \Exception  $exception
     * @return void
     */
    public function report(Exception $exception)
    {
        parent::report($exception);
    }

    /**
     * Render an exception into an HTTP response.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Exception  $exception
     * @return \Illuminate\Http\Response
     */
    public function render($request, Exception $exception)
    {
        if($exception instanceof UnauthorizedHttpException) { // no else-if because of returns
            return Utils::makeJsonResponse(false,null);
        }
        if($exception instanceof  TokenInvalidException){
            return Utils::makeJsonResponse(false,'invalid token');
        }
        if ($exception instanceof TokenExpiredException){
            return Utils::makeJsonResponse(false,'token expired');
        }
        if ($exception instanceof JWTException){
            return Utils::makeJsonResponse(false,'jwt exception');
        }
        if($exception instanceof ThrottleRequestsException) {
            return Utils::makeJsonResponse(false,'req num passed');
        }

        return parent::render($request, $exception);
    }
}
