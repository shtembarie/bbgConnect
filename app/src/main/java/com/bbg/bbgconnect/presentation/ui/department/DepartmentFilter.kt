package com.bbg.bbgconnect.presentation.ui.department

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.data.models.Department

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun DepartmentFilter(
    departments: List<Department>,
    selectedDepartmentId: String?,
    onSelectDepartment: (String?) -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                DepartmentChip(
                    label = "All",
                    isSelected = selectedDepartmentId == null,
                    onClick = { onSelectDepartment(null) }
                )
            }

            items(departments) { department ->
                DepartmentChip(
                    label = department.name,
                    isSelected = selectedDepartmentId == department.id,
                    onClick = { onSelectDepartment(department.id) }
                )
            }
        }
    }
}