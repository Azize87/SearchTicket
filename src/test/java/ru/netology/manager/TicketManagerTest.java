package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager ticketManager = new TicketManager(repository);

    Ticket firstTicket = new Ticket(1, 5600, "SVO", "KZN", 95);
    Ticket secondTicket = new Ticket(2, 7199, "VKO", "KZN", 95);
    Ticket thirdTicket = new Ticket(3, 3100, "DME", "KZN", 90);
    Ticket fourthTicket = new Ticket(4, 2100, "DME", "KZN", 90);
    Ticket fifthTicket = new Ticket(5, 6050, "DME", "KZN", 90);
    Ticket sixthTicket = new Ticket(6, 4840, "DME", "KZN", 90);
    Ticket seventhTicket = new Ticket(7, 800, "DME", "KZN", 90);
    Ticket eighthTicket = new Ticket(8, 1985, "VKO", "KZN", 90);
    Ticket ninthTicket = new Ticket(9, 1000, "VKO", "KZN", 90);


    @BeforeEach
    public void setUp() {
        ticketManager.addTicket(firstTicket);
        ticketManager.addTicket(secondTicket);
        ticketManager.addTicket(thirdTicket);
        ticketManager.addTicket(fourthTicket);
        ticketManager.addTicket(fifthTicket);
        ticketManager.addTicket(sixthTicket);
        ticketManager.addTicket(seventhTicket);
        ticketManager.addTicket(eighthTicket);
        ticketManager.addTicket(ninthTicket);

    }

    @Test
    void shouldReturnEmptyResult() {
        Ticket[] actual = ticketManager.searchBy("KZN", "DME");
        Ticket[] expected = new Ticket[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnSingleResult() {
        Ticket[] actual = ticketManager.searchBy("SVO", "KZN");
        Ticket[] expected = new Ticket[]{firstTicket};

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldReturnThreeResult() {
        Ticket[] actual = ticketManager.searchBy("VKO", "KZN");
        Ticket[] expected = new Ticket[]{ninthTicket, eighthTicket, secondTicket};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortByPrice() {
        Ticket[] actual = ticketManager.searchBy("DME", "KZN");
        Ticket[] expected = new Ticket[]{seventhTicket, fourthTicket, thirdTicket, sixthTicket, fifthTicket};

        assertArrayEquals(expected, actual);
    }


}
