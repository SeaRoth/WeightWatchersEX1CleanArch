package com.searoth.wwe1.domain.interactor.browse

import io.reactivex.Single
import com.searoth.wwe1.domain.executor.PostExecutionThread
import com.searoth.wwe1.domain.executor.ThreadExecutor
import com.searoth.wwe1.domain.interactor.SingleUseCase
import com.searoth.wwe1.domain.model.Bufferoo
import com.searoth.wwe1.domain.repository.BufferooRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class GetBufferoos @Inject constructor(val bufferooRepository: BufferooRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Bufferoo>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Bufferoo>> {
        return bufferooRepository.getBufferoos()
    }

}