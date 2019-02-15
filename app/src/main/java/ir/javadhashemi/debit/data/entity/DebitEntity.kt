package ir.javadhashemi.debit.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Oct/29 12:37
 */

@Entity(tableName = "debit")
data class DebitEntity(
        @PrimaryKey(autoGenerate = true) var id: Int = -1,
        @SerializedName("type") var type: Int,
        @SerializedName("name") var name: String,
        @SerializedName("desc") var desc: String,
        @SerializedName("cost") var cost: Int,
        @SerializedName("returned") var returnedMoney: Int,
        @SerializedName("start_d") var startDate: String,
        @SerializedName("end_d") var endDate: String,
        @SerializedName("is_done") var isDone: Boolean

)
