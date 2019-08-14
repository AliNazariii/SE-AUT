<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::post('login', 'Auth\LoginController@login');
Route::post('register', 'Auth\RegisterController@register');

Route::group(['middleware' => 'auth.jwt'], function () {
    Route::post('items', 'ItemController@store');
    Route::put('items/{id}', 'ItemController@update');
    Route::get('items', 'ItemController@index');
    Route::get('items/{id}', 'ItemController@show');
    Route::delete('items/{id}', 'ItemController@delete');

    Route::post('orders', 'OrderController@store');
    Route::put('orders/{id}', 'OrderController@update');
    Route::get('orders', 'OrderController@index');
    Route::get('orders/{id}', 'OrderController@show');
    Route::delete('orders/{id}', 'OrderController@delete');

    Route::post('items/{item_id}/comments', 'CommentController@store');
    Route::get('items/{item_id}/comments', 'CommentController@index');
    Route::get('items/{item_id}/comments/{id}', 'CommentController@show');
});
