package com.example.mediundoctorhome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import mediundoctorhome.composeapp.generated.resources.Res
import mediundoctorhome.composeapp.generated.resources.compose_multiplatform
import mediundoctorhome.composeapp.generated.resources.ic_arrow_right
import mediundoctorhome.composeapp.generated.resources.ic_calendar
import mediundoctorhome.composeapp.generated.resources.ic_clock
import mediundoctorhome.composeapp.generated.resources.ic_search
import mediundoctorhome.composeapp.generated.resources.ic_location
import mediundoctorhome.composeapp.generated.resources.ic_home_filled
import mediundoctorhome.composeapp.generated.resources.ic_home_outline
import mediundoctorhome.composeapp.generated.resources.ic_nav_calendar
import mediundoctorhome.composeapp.generated.resources.ic_nav_message
import mediundoctorhome.composeapp.generated.resources.ic_nav_profile
import mediundoctorhome.composeapp.generated.resources.ic_sun
import mediundoctorhome.composeapp.generated.resources.ic_profile_add
import mediundoctorhome.composeapp.generated.resources.ic_greeking_group
import mediundoctorhome.composeapp.generated.resources.ic_link
import mediundoctorhome.composeapp.generated.resources.ic_hospital
import mediundoctorhome.composeapp.generated.resources.avatar_imran
import mediundoctorhome.composeapp.generated.resources.avatar_joseph

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(color = Color(0xFFFFFFFF)) {
            HomeScreen()
        }
    }
}

@Composable
private fun HomeScreen() {
        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        TopGreeting(name = "James")
        AppointmentCard()
        SearchField()
        CategoriesRow()
        NearDoctorSection()
        BottomNavigation()
    }
}

@Composable
private fun TopGreeting(name: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = "Hello,",
                color = Color(0xFF8696BB),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Hi $name",
                color = Color(0xFF0D1B34),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        // Right profile avatar
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
        ){
            Image(
                painter = painterResource(Res.drawable.ic_greeking_group),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun AppointmentCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4894FE), RoundedCornerShape(12.dp))
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                ){
                    Image(
                        painter = painterResource(Res.drawable.avatar_imran),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Dr. Imran Syahir",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "General Doctor",
                        color = Color(0xFFCBE1FF),
                        fontSize = 14.sp
                    )
                }
            }
            Image(
                painter = painterResource(Res.drawable.ic_arrow_right),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.ic_calendar),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sunday, 12 June",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.ic_clock),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "11:00 - 12:00 AM",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun SearchField() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFAFAFA), RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "Search doctor or health issue",
            color = Color(0xFF8696BB),
            fontSize = 15.sp
        )
    }
}

@Composable
private fun CategoriesRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryItem(label = "Covid 19", icon = Res.drawable.ic_sun)
        CategoryItem(label = "Doctor", icon = Res.drawable.ic_profile_add)
        CategoryItem(label = "Medicine", icon = Res.drawable.ic_link)
        CategoryItem(label = "Hospital", icon = Res.drawable.ic_hospital)
    }
}

@Composable
private fun CategoryItem(label: String, icon: DrawableResource) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(Color(0xFFFAFAFA)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, color = Color(0xFF8696BB), fontSize = 15.sp)
    }
}

@Composable
private fun NearDoctorSection() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Near Doctor",
            color = Color(0xFF0D1B34),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        DoctorCard(
            name = "Dr. Joseph Brostito",
            subtitle = "Dental Specialist",
            distanceText = "1.2 KM",
            avatar = Res.drawable.avatar_joseph,
            trailingPrimary = Pair(Res.drawable.ic_clock, Color(0xFF4894FE)),
            trailingPrimaryText = "Open at 17.00",
            trailingSecondary = Pair(Res.drawable.ic_clock, Color(0xFFFEB052)),
            trailingSecondaryText = "4,8 (120 Reviews)"
        )
        DoctorCard(
            name = "Dr. Imran Syahir",
            subtitle = "General Doctor",
            distanceText = "1.2 KM",
            avatar = Res.drawable.avatar_imran,
            trailingPrimary = Pair(Res.drawable.ic_clock, Color(0xFF4894FE)),
            trailingPrimaryText = "Open at 17.00",
            trailingSecondary = Pair(Res.drawable.ic_clock, Color(0xFFFEB052)),
            trailingSecondaryText = "4,8 (120 Reviews)"
        )
    }
}

@Composable
private fun DoctorCard(
    name: String,
    subtitle: String,
    distanceText: String,
    avatar: DrawableResource,
    trailingPrimary: Pair<DrawableResource, Color>,
    trailingPrimaryText: String,
    trailingSecondary: Pair<DrawableResource, Color>,
    trailingSecondaryText: String
) {
                Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(
                width = 0.0.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Row(
                    modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                ){
                    Image(
                        painter = painterResource(avatar),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = name, color = Color(0xFF0D1B34), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = subtitle, color = Color(0xFF8696BB), fontSize = 14.sp)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = distanceText, color = Color(0xFF8696BB), fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(trailingPrimary.first),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = trailingPrimaryText, color = trailingPrimary.second, fontSize = 12.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(trailingSecondary.first),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = trailingSecondaryText, color = trailingSecondary.second, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun BottomNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomItem(active = true, label = "Home", iconActive = Res.drawable.ic_home_filled, iconInactive = Res.drawable.ic_home_outline)
        BottomItem(active = false, label = "Calendar", iconActive = Res.drawable.ic_nav_calendar, iconInactive = Res.drawable.ic_nav_calendar)
        BottomItem(active = false, label = "Message", iconActive = Res.drawable.ic_nav_message, iconInactive = Res.drawable.ic_nav_message)
        BottomItem(active = false, label = "Profile", iconActive = Res.drawable.ic_nav_profile, iconInactive = Res.drawable.ic_nav_profile)
    }
}

@Composable
private fun BottomItem(active: Boolean, label: String, iconActive: DrawableResource, iconInactive: DrawableResource) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(if (active) iconActive else iconInactive),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            contentScale = ContentScale.Fit
        )
        if (active) {
            Text(text = label, color = Color(0xFF63B4FF), fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}