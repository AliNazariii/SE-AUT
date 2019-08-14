<?php

use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateRolesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('roles', function (Blueprint $table) {
            //guide in DB
            //role == 1 :: customer
            //role == 2 :: order_manager
            //role == 3 :: chief
            $table->increments('id');
            $table->string('role');
        });

        // Insert some stuff
        DB::table('roles')->insert(array('role' => 'customer',));
        DB::table('roles')->insert(array('role' => 'order_manager',));
        DB::table('roles')->insert(array('role' => 'chief',));
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('roles');
    }
}
