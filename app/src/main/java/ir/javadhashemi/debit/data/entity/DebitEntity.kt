package ir.javadhashemi.debit.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Oct/29 12:37
 */

@Entity(tableName = "debit")
data class DebitEntity(
        @PrimaryKey var id: Int = -1,
        @SerializedName("type") var type: Int,
        @SerializedName("name") var name: String,
        @SerializedName("desc") var desc: String,
        @SerializedName("cost") var cost: Int,
        @SerializedName("returned") var returnedMoney: Int,
        @SerializedName("start_d") var startDate: Int,
        @SerializedName("end_d") var endDate: Int,
        @SerializedName("is_done") var isDone: Boolean

)
