package com.ffai.optimizer.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Optimizer", "Sensitivity", "HUD", "Scan")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1F1F1F))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "🔥 FF AI Optimizer Pro",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Content Area
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            when (selectedTab) {
                0 -> FeatureContent("⚡ Game Optimizer", "Enhances performance, clears RAM, and reduces ping.")
                1 -> FeatureContent("🎯 Pro Sensitivity", "Best DPI and sensitivity settings for headshots.")
                2 -> FeatureContent("📱 Custom HUD", "Optimized 3 and 4-finger layouts.")
                3 -> FeatureContent("🔍 Device Scan", "Analyzing hardware capabilities for maximum FPS.")
            }
        }

        // Bottom Navigation Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1F1F1F))
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tabs.forEachIndexed { index, title ->
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == index) Color(0xFFFF5722) else Color.Transparent
                    ),
                    onClick = { selectedTab = index }
                ) {
                    Text(title, color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun FeatureContent(title: String, description: String) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFF5722))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = description, fontSize = 14.sp, color = Color.LightGray, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)),
            onClick = { }
        ) {
            Text("Apply & Optimize Now", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}
