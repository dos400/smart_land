package uz.hamroev.smartland.firebase.model

import java.io.Serializable

class Product : Serializable {

    var product_name: String? = null
    var product_percentage: Int? = null


    constructor()

    constructor(product_name: String?, product_percentage: Int?) {
        this.product_name = product_name
        this.product_percentage = product_percentage
    }


}