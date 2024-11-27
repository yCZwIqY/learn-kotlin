package com.example.learnkotlin.presentation.service

import com.example.learnkotlin.domain.entity.Introduction
import com.example.learnkotlin.domain.entity.Link
import com.example.learnkotlin.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductions() {
        //given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "$i", isActive = i % 2 == 0)
            introductions.add(introduction)
        }

        val activeIntroduction = introductions.filter { it.isActive }

        Mockito.`when`(presentationRepository.getActiveIntroduction())
                .thenReturn(activeIntroduction)

        //when
        val introductionDTOs = presentationService.getIntroductions()

        //then
        assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOs) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks() {
        //given
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            val link = Link(name = "$i", content = "$i", isActive = i % 2 != 0)
            links.add(link)
        }

        val activeLink = links.filter { it.isActive }

        Mockito.`when`(presentationRepository.getActiveLinks())
                .thenReturn(activeLink)
        //when
        val linkDTOs = presentationService.getLinks()
        //then
        var expectSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) {
            expectSize += 1
        }

        assertThat(linkDTOs).hasSize(expectSize)

        for (linkDTO in linkDTOs) {
            assertThat(linkDTO.name.toInt()).isOdd()
        }
    }

}