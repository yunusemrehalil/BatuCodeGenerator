package com.nomaddeveloper.batucodegenerator.model

class ProductModel {
    private var productId: Int = 0
    private var productName: String = ""
    private var productPrice: Double = 0.0
    private var productCategory: String = ""
    private var productImage: String = ""
    private var productCode: String = ""
    private var productDecode: String = ""

    fun getProductId(): Int {
        return productId
    }

    fun setProductId(productId: Int) {
        this.productId = productId
    }

    fun getProductName(): String {
        return productName
    }

    fun setProductName(productName: String) {
        this.productName = productName
    }

    fun getProductPrice(): Double {
        return productPrice
    }

    fun setProductPrice(productPrice: Double) {
        this.productPrice = productPrice
    }

    fun getProductImage(): String {
        return productImage
    }

    fun setProductImage(productImage: String) {
        this.productImage = productImage
    }

    fun getProductCode(): String {
        return productCode
    }

    fun setProductCode(productCode: String) {
        this.productCode = productCode
    }

    fun getProductDecode(): String {
        return productDecode
    }

    fun setProductDecode(productDecode: String) {
        this.productDecode = productDecode
    }

    fun getProductCategory(): String {
        return productCategory
    }

    fun setProductCategory(productCategory: String) {
        this.productCategory = productCategory
    }
}
