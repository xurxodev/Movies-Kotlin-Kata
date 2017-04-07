package com.xurxodev.movieskotlinkata

fun getItems(): List<Item> {
    var items:MutableList<Item> = mutableListOf<Item>()

    val BASE_ADDRESS = "https://image.tmdb.org/t/p/w1300_and_h730_bestv2/"

    items.add(Item(1,"Inferno", BASE_ADDRESS + "anmLLbDx9d98NMZRyVUtxwJR6ab.jpg"))
    items.add(Item(2,"Jack Reacher: Never Go Back", BASE_ADDRESS + "4ynQYtSEuU5hyipcGkfD6ncwtwz.jpg"))
    items.add(Item(3,"Star Trek Beyond","" + BASE_ADDRESS + "doqRJwhRFsHHneYG82bM0hSTqpz.jpg"))
    items.add(Item(4,"Doctor Strange", BASE_ADDRESS + "2wgKgQAqso1p1yP6unsq9nl7Xdc.jpg"))
    items.add(Item(5,"The Girl on the Train", BASE_ADDRESS + "fpq86AP0YBYUwNgDvUj5kxwycxH.jpg"))
    items.add(Item(6,"Deepwater Horizon", BASE_ADDRESS + "zjYdnBHbIOYBqKZxvBUsT5MevUA.jpg"))
    items.add(Item(7,"A Monster Calls", BASE_ADDRESS + "xVW8REyVqKwxAtUYY07UGlZH43L.jpg"))

    return items.toList()
}

data class Item (val id:Long, val title:String, val url:String)