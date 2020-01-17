package com.evg.entity

import com.evg.toSlug
import java.time.LocalDateTime
import javax.persistence.*


@Entity
data class Article(
    val title: String,
    val headline: String,
    val content: String,
    @ManyToOne val author: User,
    val slug: String = title.toSlug(),
    val addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null)