package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.util.AppStrings
import com.example.model.AppLanguage
import com.example.ui.theme.*
import com.example.viewmodel.AppNavTab

@Composable
fun BottomNavBar(
    currentTab: AppNavTab,
    appLanguage: AppLanguage = AppLanguage.TR,
    onTabSelected: (AppNavTab) -> Unit
) {
    val strings = remember(appLanguage) { AppStrings.get(appLanguage) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        color = DarkSurface,
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(DarkCardBorder))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppNavTab.values().forEach { tab ->
                val isSelected = tab == currentTab
                val icon = getTabIcon(tab, isSelected)
                val color = if (isSelected) PrimaryIndigo else TextMuted
                val tabTitle = when (tab) {
                    AppNavTab.HOME -> strings.tabHome
                    AppNavTab.COURSES -> strings.tabCourses
                    AppNavTab.ROADMAP -> strings.tabRoadmap
                    AppNavTab.PRACTICE -> strings.tabPractice
                    AppNavTab.PROFILE -> strings.tabProfile
                }

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) PrimarySubtle else Color.Transparent)
                        .clickable { onTabSelected(tab) }
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .testTag("nav_tab_${tab.name.lowercase()}"),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = tabTitle,
                        tint = color,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = tabTitle,
                        fontSize = 10.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = color
                    )
                }
            }
        }
    }
}

private fun getTabIcon(tab: AppNavTab, isSelected: Boolean): ImageVector = when (tab) {
    AppNavTab.HOME -> if (isSelected) Icons.Filled.Home else Icons.Outlined.Home
    AppNavTab.COURSES -> if (isSelected) Icons.Filled.MenuBook else Icons.Outlined.MenuBook
    AppNavTab.ROADMAP -> if (isSelected) Icons.Filled.AltRoute else Icons.Outlined.AltRoute
    AppNavTab.PRACTICE -> if (isSelected) Icons.Filled.Terminal else Icons.Outlined.Terminal
    AppNavTab.PROFILE -> if (isSelected) Icons.Filled.Person else Icons.Outlined.Person
}
