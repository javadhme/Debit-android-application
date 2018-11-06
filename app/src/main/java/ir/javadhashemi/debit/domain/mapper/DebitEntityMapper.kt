package ir.javadhashemi.debit.domain.mapper

import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.domain.model.DebitModel

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 10:02
 */
class DebitEntityMapper : BaseMapper<DebitEntity, DebitModel> {

    override fun map(input: DebitEntity): DebitModel =
            DebitModel(
                    localId = input.id,
                    type = input.type,
                    name = input.name,
                    cost = input.cost,
                    desc = input.desc,
                    endDate = input.endDate,
                    isDone = input.isDone,
                    returnedMoney = input.returnedMoney,
                    startDate = input.startDate
            )


}