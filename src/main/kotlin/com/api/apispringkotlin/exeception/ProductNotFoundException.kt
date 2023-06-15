package com.api.apispringkotlin.exeception

class ProductNotFoundException(error: String) : Exception(error) {}