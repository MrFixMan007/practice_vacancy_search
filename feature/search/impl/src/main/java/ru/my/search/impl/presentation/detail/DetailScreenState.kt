package ru.my.search.impl.presentation.detail

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.my.base.api.screenmodel.model.UIState
import ru.my.uicommon.R

@Immutable
data class DetailScreenState(
    val title: String = "UI/UX Designer",
    val incomeLevel: String = "Уровень дохода не указан",
    val requiredExperience: String = "Требуемый опыт: от 1 года до 3 лет",
    val timeline: String = "Полная занятость, полный день",
    val company: String = "Мобирикс",
    val address: String = "Минск, улица Бирюзова, 4/5",
    @DrawableRes val addressPainterRes: Int = R.drawable.map,
    val companyDescription: String = """
                MOBYRIX - динамично развивающаяся продуктовая IT-компания, специализирующаяся на разработке мобильных приложений для iOS и Android. Наша команда работает над собственными продуктами в разнообразных сферах: от утилит до развлечений и бизнес-приложений.
                Мы ценим талант и стремление к инновациям и в данный момент в поиске талантливого UX/UI Designer, готового присоединиться к нашей команде и внести значимый вклад в развитие наших проектов.
            """.trimIndent(),
    val jobDescription: String = """
                -Проектировать пользовательский опыт, проводить UX исследования;
                -Разрабатывать адаптивный дизайн интерфейса для мобильных приложений;
                -Разрабатывать быстрые прототипы для тестирования идеи дизайна и их последующая; интеграция на основе обратной связи от команды и пользователей;
                -Взаимодействовать с командой разработчиков для обеспечения точной реализации ваших дизайнов;
                -Анализ пользовательского опыта и адаптация под тренды.
            """.trimIndent(),
    val questions: ImmutableList<String> = persistentListOf(
        "Где распологается место работы?",
        "Какой график работы?",
        "Вакансия открыта?",
        "Какая оплата труда?",
    ),
    val isFavourite: Boolean = true,
    val peopleRespondedCount: Int = 147,
    val peopleWatchingCount: Int = 2,
) : UIState