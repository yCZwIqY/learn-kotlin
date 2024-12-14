package com.example.learnkotlin.admin.context.link.service

import com.example.learnkotlin.admin.context.link.form.LinkForm
import com.example.learnkotlin.admin.data.TableDTO
import com.example.learnkotlin.domain.entity.Link
import com.example.learnkotlin.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(val linkRepository: LinkRepository) {
    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    fun save(form: LinkForm) {
        val link = form.toEntity()
        linkRepository.save(link)
    }

    fun update(id: Long, form: LinkForm) {
        val link = form.toEntity(id)
        linkRepository.save(link)
    }
}