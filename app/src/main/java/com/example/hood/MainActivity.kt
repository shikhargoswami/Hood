package com.example.hood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hood.R.drawable.celebrity_post
import com.example.hood.ui.theme.HoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HoodTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.InstagramPost.route
                ) {
                    composable(Screen.InstagramPost.route) { InstagramPostScreen(navController) }
                    composable(Screen.Welcome.route) { WelcomeScreen(navController) }
                    composable(Screen.BodyMeasurement.route) { BodyMeasurementScreen(navController) }
                    composable(Screen.VirtualTryOn.route) { VirtualTryOnScreen(navController) }
                    composable(Screen.ProductDetails.route) { ProductDetailsScreen(navController) }
                    composable(Screen.Checkout.route) { CheckoutScreen(navController) }
                    composable(Screen.OrderTracking.route) { OrderTrackingScreen(navController) }
                    composable(Screen.ThankYou.route) { ThankYouScreen(navController) }
                }
            }
        }
    }
}
@Composable
fun InstagramPostScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = celebrity_post), // Replace with your image
            contentDescription = "Celebrity Post",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = { navController.navigate(Screen.Welcome.route) },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Try It On at Hood")
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to Hood!",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Try on celebrity outfits virtually and get them tailored near you!",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate(Screen.BodyMeasurement.route) }) {
            Text("Start Your Virtual Try-On")
        }
    }
}

@Composable
fun BodyMeasurementScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Let’s Get Your Perfect Fit!",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Upload 2-3 full-body photos (front, side, back) in form-fitting clothing.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate(Screen.VirtualTryOn.route) }) {
            Text("Upload Photos")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Get 15% off for completing this step!",
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Your photos will only be used for measurements and will not be stored.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun VirtualTryOnScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your Virtual Try-On",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Placeholder for 3D try-on view
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate(Screen.ProductDetails.route) }) {
            Text("See Price and Details")
        }
    }
}

@Composable
fun ProductDetailsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Celebrity Outfit - Tailored Just for You!",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.product_image), // Replace with your image
            contentDescription = "Product Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Price: ₹2,000")
        Text(
            text = "15% off applied!",
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tailored by [Tailor Name] in [City]")
        Text(text = "Rating: ⭐⭐⭐⭐☆")
        Text(text = "Estimated Delivery: 5-7 days")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate(Screen.Checkout.route) }) {
            Text("Add to Cart")
        }
    }
}

@Composable
fun CheckoutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Checkout",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Order Summary:")
        Text(text = "Outfit Name: Celebrity Outfit")
        Text(text = "Price: ₹2,000")
        Text(text = "Discount: ₹300")
        Text(text = "Total: ₹1,700")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Shipping Address: [User Address]")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Payment Options: UPI, Credit/Debit Cards, Wallets")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate(Screen.OrderTracking.route) }) {
            Text("Place Order")
        }
    }
}

@Composable
fun OrderTrackingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Your Order Status",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tailor Assigned")
        Text(text = "Production in Progress")
        Text(text = "Out for Delivery")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Estimated Delivery Date: [Date]")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Need help? Contact your tailor at [Phone Number]")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate(Screen.ThankYou.route) }) {
            Text("Continue")
        }
    }
}

@Composable
fun ThankYouScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Thank You for Shopping with Hood!",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Share your virtual try-on experience and get ₹100 off your next order!",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { /* Share on social media */ }) {
            Text("Share on Instagram")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Share on social media */ }) {
            Text("Share on Facebook")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Refer a friend and earn ₹200 when they make their first purchase!",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}