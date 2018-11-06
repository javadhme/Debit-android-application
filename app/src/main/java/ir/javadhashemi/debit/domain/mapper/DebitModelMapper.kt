package ir.javadhashemi.debit.domain.mapper

import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.domain.model.DebitModel

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 10:06
 */
class DebitModelMapper : BaseMapper<DebitModel, DebitEntity> {

    override fun map(input: DebitModel): DebitEntity =
            DebitEntity(
                    id = input.localId,
                    startDate = input.startDate,
                    returnedMoney = input.returnedMoney,
                    isDone = input.isDone,
                    endDate = input.endDate,
                    desc = input.desc,
                    cost = input.cost,
                    name = input.name,
                    type = input.type
            )


}