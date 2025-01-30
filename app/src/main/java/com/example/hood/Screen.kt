package com.example.hood

sealed class Screen(val route: String) {
    object InstagramPost : Screen("instagram_post")
    object Welcome : Screen("welcome")
    object BodyMeasurement : Screen("body_measurement")
    object VirtualTryOn : Screen("virtual_try_on")
    object ProductDetails : Screen("product_details")
    object Checkout : Screen("checkout")
    object OrderTracking : Screen("order_tracking")
    object ThankYou : Screen("thank_you")
}