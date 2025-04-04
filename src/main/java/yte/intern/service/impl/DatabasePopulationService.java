package yte.intern.service.impl;

import org.springframework.stereotype.Service;
import yte.intern.common.enums.Authorities;
import yte.intern.model.Attendee;
import yte.intern.model.Event;
import yte.intern.repository.AttendeeRepository;
import yte.intern.repository.EventRepository;
import yte.intern.repository.UserProfileRepository;
import yte.intern.service.IEventService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class DatabasePopulationService {

    private final AuthorityService authorityService;
    private final RegisterService registerService;
    private final IEventService eventService;
    private final AttendeeService attendeeService;

    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;
    private final UserProfileRepository userProfileRepository;

    public DatabasePopulationService(
            AuthorityService authorityService,
            RegisterService registerService,
            IEventService eventService,
            AttendeeService attendeeService,
            EventRepository eventRepository,
            UserProfileRepository userProfileRepository,
            AttendeeRepository attendeeRepository
    ) {

        this.authorityService = authorityService;
        this.registerService = registerService;
        this.eventService = eventService;
        this.attendeeService = attendeeService;

        this.eventRepository = eventRepository;
        this.userProfileRepository = userProfileRepository;
        this.attendeeRepository = attendeeRepository;

    }

    public void populateDatabase() {
        populateAuthorities();
        populateUsers();
        populateEvents();
        populateAttendeesEvent1();
        populateAttendeesEvent2();
    }

    private void populateAuthorities() {
        authorityService.createAuthorityChecked(Authorities.ROOT.getValue());
        authorityService.createAuthorityChecked(Authorities.ADMIN.getValue());
        authorityService.createAuthorityChecked(Authorities.INTERNAL.getValue());
        authorityService.createAuthorityChecked(Authorities.EXTERNAL.getValue());
    }

    private void populateUsers() {
        //ToDo random admin password
        registerService.registerUser(
                10000000000L,
                "admin@mail.com",
                "name/admin",
                "surname/admin",
                LocalDate.now(),
                "admin",
                "admin",
                Authorities.ADMIN
        );

        registerService.registerUser(
                20000000000L,
                "internal_test@mail.com",
                "name/internal_test",
                "surname/internal_test",
                LocalDate.now(),
                "in",
                "in",
                Authorities.INTERNAL
        );

        registerService.registerUser(
                30000000000L,
                "ex1_address@mail.com.tr",
                "name/external_test1",
                "surname/external_test1",
                LocalDate.now(),
                "ex1",
                "ex1",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                40000000000L,
                "external_test2@mail.com",
                "name/external_test2",
                "surname/external_test2",
                LocalDate.now(),
                "ex2",
                "ex2",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                47207690252L,
                "verna87@mail.com",
                "Verna",
                "Fosse",
                LocalDate.of(1987, 10, 20),
                "foss",
                "verna.87.FOSS",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                54801344672L,
                "jacky65@mail.com",
                "Jacky",
                "Clement",
                LocalDate.of(1965, 6, 5),
                "clementine",
                "j000.65jordan",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                90190861352L,
                "mervin_babel@mail.com",
                "Mervin",
                "Babel",
                LocalDate.of(1967, 3, 27),
                "MERVin",
                "notA123pass*",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                35149882460L,
                "jhonny@mail.com",
                "Jhon",
                "Iron",
                LocalDate.of(1984, 3, 26),
                "jhon84",
                "passWord123*",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                16463644194L,
                "ana@mail.com",
                "Ana",
                "Coop",
                LocalDate.of(1995, 2, 27),
                "coop",
                "passPass123*",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                20578439446L,
                "May@mail.com",
                "May",
                "June",
                LocalDate.of(1997, 11, 2),
                "mayjune",
                "pAssss654*",
                Authorities.EXTERNAL
        );

        registerService.registerUser(
                25373108054L,
                "Sally@mail.com",
                "Sally",
                "Ten",
                LocalDate.of(2001, 1, 30),
                "sall",
                "654saL456*",
                Authorities.EXTERNAL
        );

    }

    private void populateEvents() {
        Event event1 = eventService.createEvent(
                "Learn AI/ML",
                "Register to learn in depth about application of AI and ML",
                LocalDateTime.of(LocalDate.of(2025, 5, 10), LocalTime.of(12, 0, 0)),
                LocalDateTime.of(LocalDate.of(2025, 6, 15), LocalTime.of(18, 15, 0)),
                20,
                "CSE Lab 1",
                "1",
                "1"
        );
        event1.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2025, 2, 3),
                        LocalTime.of(7, 15, 0)
                )
        );
        eventRepository.save(event1);

        Event event2 = eventService.createEvent(
                "Cooking Workshop",
                "Ten day workshop to learn basic cooking",
                LocalDateTime.of(LocalDate.of(2025, 4, 20), LocalTime.of(8, 0, 0)),
                LocalDateTime.of(LocalDate.of(2025, 8, 27), LocalTime.of(8, 0, 0)),
                2,
                "Cooking Lab",
                "2",
                "2"
        );
        event2.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2025, 4, 18),
                        LocalTime.of(8, 0, 0)
                )
        );
        eventRepository.save(event2);

        Event event3 = eventService.createEvent(
                "Painting Fun",
                "Learn with us about basics of painting",
                LocalDateTime.of(LocalDate.of(2025, 8, 20), LocalTime.of(15, 0, 0)),
                LocalDateTime.of(LocalDate.of(2025, 8, 22), LocalTime.of(16, 30, 0)),
                30,
                "Art Lab",
                "3",
                "3"
        );
        event3.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2025, 8, 18),
                        LocalTime.of(10, 0, 0)
                )
        );
        eventRepository.save(event3);

        Event event4 = eventService.createEvent(
                "Bird Watching",
                "Bird Watching event with group of people",
                LocalDateTime.of(LocalDate.of(2025, 9, 1), LocalTime.of(10, 20, 0)),
                LocalDateTime.of(LocalDate.of(2025, 9, 20), LocalTime.of(18, 40, 0)),
                40,
                "Infront of AB1",
                "4",
                "4"
        );
        event4.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2025, 8, 15),
                        LocalTime.of(14, 30, 0)
                )
        );
        eventRepository.save(event4);

        eventService.createEvent(
                "Music of Today",
                "Master music in this 5 day workshop",
                LocalDateTime.of(LocalDate.of(2021, 5, 12), LocalTime.of(19, 30, 0)),
                LocalDateTime.of(LocalDate.of(2021, 6, 14), LocalTime.of(19, 30, 0)),
                2,
                "Music Room",
                "5",
                "5"
        );

        eventService.createEvent(
                "Fun Frenzy",
                "Disco event on latest music",
                LocalDateTime.of(LocalDate.of(2021, 4, 18), LocalTime.of(8, 30, 0)),
                LocalDateTime.of(LocalDate.of(2021, 5, 18), LocalTime.of(22, 45, 0)),
                10,
                "Dance Class 1",
                "6",
                "6"
        );

        eventService.createEvent(
                "Mathify",
                "Learn to master mathematics in a course of 15 days",
                LocalDateTime.of(LocalDate.of(2025, 4, 20), LocalTime.of(10, 20, 0)),
                LocalDateTime.of(LocalDate.of(2022, 5, 1), LocalTime.of(12, 0, 0)),
                15,
                "Maths Lab",
                "7",
                "7"
        );
    }

    private void populateAttendeesEvent1() {

        attendeeService.createAttendee(47207690252L, 1L);
        Attendee attendee1 = attendeeService.getByUserTcAndEventId(47207690252L, 1L);
        attendee1.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 2, 3),
                        LocalTime.of(18, 0, 0)
                )
        );
        attendeeRepository.save(attendee1);

        attendeeService.createAttendee(54801344672L, 1L);
        Attendee attendee2 = attendeeService.getByUserTcAndEventId(54801344672L, 1L);
        attendee2.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 2, 3),
                        LocalTime.of(16, 20, 0)
                )
        );
        attendeeRepository.save(attendee2);

        attendeeService.createAttendee(90190861352L, 1L);
        Attendee attendee3 = attendeeService.getByUserTcAndEventId(90190861352L, 1L);
        attendee3.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 2, 5),
                        LocalTime.of(8, 0, 0)
                )
        );
        attendeeRepository.save(attendee3);

        attendeeService.createAttendee(35149882460L, 1L);
        Attendee attendee4 = attendeeService.getByUserTcAndEventId(35149882460L, 1L);
        attendee4.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 2, 6),
                        LocalTime.of(15, 45, 0)
                )
        );
        attendeeRepository.save(attendee4);

        attendeeService.createAttendee(16463644194L, 1L);
        Attendee attendee5 = attendeeService.getByUserTcAndEventId(16463644194L, 1L);
        attendee5.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 2, 9),
                        LocalTime.of(20, 35, 0)
                )
        );
        attendeeRepository.save(attendee5);

        attendeeService.createAttendee(20578439446L, 1L);
        Attendee attendee6 = attendeeService.getByUserTcAndEventId(20578439446L, 1L);
        attendee6.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 2, 9),
                        LocalTime.of(22, 0, 0)
                )
        );
        attendeeRepository.save(attendee6);

        attendeeService.createAttendee(25373108054L, 1L);
        Attendee attendee7 = attendeeService.getByUserTcAndEventId(25373108054L, 1L);
        attendee7.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 2, 9),
                        LocalTime.of(23, 20, 0)
                )
        );
        attendeeRepository.save(attendee7);

    }

    private void populateAttendeesEvent2() {

        attendeeService.createAttendee(35149882460L, 2L);
        Attendee attendee1 = attendeeService.getByUserTcAndEventId(35149882460L, 2L);
        attendee1.setCreationDate(
                LocalDateTime.of(
                        LocalDate.of(2021, 1, 19),
                        LocalTime.of(15, 0, 0)
                )
        );
        attendeeRepository.save(attendee1);


    }

}
