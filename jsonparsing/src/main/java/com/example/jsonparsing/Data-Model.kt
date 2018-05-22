package com.example.jsonparsing

data class Obj(
        val inv:String,
        val age:Int
)
data class MainObj(
        val os: String,
        val nm:String,
        val vs:Int,
        val obj:Obj,
        val list:List<Obj> = ArrayList()
)