<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class ItemsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {

        DB::table('items')->insert([
            'category' => 'foods',
            'name' => 'Kebab',
            'price' => 12000,
            'count' => 20,
            'available' => true,
            'description' => 'high quality meat',
            'image_url' => 'http://s8.picofile.com/file/8365087568/kebab.jpg',
        ]);
        DB::table('items')->insert([
            'category' => 'foods',
            'name' => 'Chicken',
            'price' => 15000,
            'count' => 7,
            'available' => true,
            'description' => 'Offer of Chef for today',
            'image_url' => 'http://s8.picofile.com/file/8365087876/chicken.jpg',
        ]);
        DB::table('items')->insert([
            'category' => 'foods',
            'name' => 'Pizza',
            'price' => 10000,
            'count' => 10,
            'available' => true,
            'description' => 'Best pizza you can find ever!',
            'image_url' => 'http://s8.picofile.com/file/8365087750/pizza.jpg',
        ]);
        DB::table('items')->insert([
            'category' => 'foods',
            'name' => 'Fried Potato',
            'price' => 9000,
            'count' => 32,
            'available' => true,
            'description' => 'No Description here',
            'image_url' => 'http://s9.picofile.com/file/8365087934/potato.jpg',
        ]);
        DB::table('items')->insert([
            'category' => 'foods',
            'name' => 'Pasta',
            'price' => 8000,
            'count' => 15,
            'available' => true,
            'description' => 'high quality pasta with special sauce',
            'image_url' => 'http://s8.picofile.com/file/8365087768/pasta.jpg',
        ]);
        DB::table('items')->insert([
            'category' => 'pre-meal',
            'name' => 'Salad',
            'price' => 5000,
            'count' => 40,
            'available' => true,
            'description' => 'Best vegetables gathered here!',
            'image_url' => 'http://s8.picofile.com/file/8365088018/salad.jpg',
        ]);
        DB::table('items')->insert([
            'category' => 'drinks',
            'name' => 'Coca',
            'price' => 2500,
            'count' => 80,
            'available' => true,
            'description' => 'Coca drink',
            'image_url' => 'http://s8.picofile.com/file/8365088050/coca.jpg',
        ]);
        DB::table('items')->insert([
            'category' => 'drinks',
            'name' => 'Water',
            'price' => 2000,
            'count' => 50,
            'available' => true,
            'description' => 'just water',
            'image_url' => 'http://s8.picofile.com/file/8365088118/water.jpg',
        ]);
    }
}
