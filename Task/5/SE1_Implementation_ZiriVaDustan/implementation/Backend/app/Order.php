<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Order extends Model
{

    protected $casts = [
        'items' => 'array'
    ];
    public function user() {
        return $this->belongsTo(User::class);
    }

    public function public_data() {
        return [
            'id' => $this->id,
            'state' => $this->state,
            'description' => $this->description,
            'totalCost' => $this->totalCost
        ];
    }
}
