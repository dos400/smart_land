package uz.hamroev.smartland.firebase.model

class Product {

    var product_name: String? = null
    var product_percentage: Int? = null
    var seasons: String? = null

    constructor()

    constructor(product_name: String?, product_percentage: Int?, seasons: String?) {
        this.product_name = product_name
        this.product_percentage = product_percentage
        this.seasons = seasons
    }

}