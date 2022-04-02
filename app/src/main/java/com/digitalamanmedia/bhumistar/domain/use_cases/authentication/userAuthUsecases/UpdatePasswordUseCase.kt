package com.digitalamanmedia.bhumistar.domain.use_cases.authentication.userAuthUsecases


import com.digitalamanmedia.bhumistar.core.utils.GetResponse
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.UpdatePasswordDto
import com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.toNormalResponseModal
import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal
import com.digitalamanmedia.bhumistar.domain.repository.remote.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdatePasswordUseCase @Inject constructor(
    private val usersRepository: UsersRepository
){
    operator fun invoke(updatePasswordDto: UpdatePasswordDto): Flow<Resource<NormalResponseModal>>{
        return GetResponse.result {
            usersRepository.updatePassword(updatePasswordDto).toNormalResponseModal()
        }
    }
}