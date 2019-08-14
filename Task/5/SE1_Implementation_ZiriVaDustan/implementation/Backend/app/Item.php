<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Item extends Model
{
    public function comments() {
        return $this->hasMany(Comment::class);
    }
}
