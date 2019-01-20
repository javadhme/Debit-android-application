package ir.javadhashemi.debit.domain.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.domain.mapper.DebitModelMapper
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.repository.DebitRepository
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Inject

@RunWith(MockitoJUnitRunner::class)
class EditDebitUseCaseTest {

    @Mock
    lateinit var debitRepository: DebitRepository

    @Mock
    lateinit var mapper: DebitModelMapper

    @InjectMocks
    lateinit var editDebitUseCase: EditDebitUseCase /*by lazy { EditDebitUseCase(debitRepository, mapper) }*/

    @Mock
    lateinit var debitEntity: DebitEntity
/*
    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }*/

    @Test
    fun `execute should get an any instance` () {
        // given
//        val predictedValue = 0
//        whenever(debitRepository.editDebit(debitEntity)).thenReturn(predictedValue)
//
//        val mockDebit = mock<DebitModel>()
//        val actualValue = editDebitUseCase.execute(mockDebit)
//
//        assertThat(actualValue, `is`(predictedValue))
    }

}