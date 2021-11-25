package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager ticketManager = new TicketManager(repository);

    Ticket firstTicket = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket secondTicket = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket thirdTicket = new Ticket(3, 3100, "DME", "KZN", 90);
    Ticket fourthTicket = new Ticket(4, 2100, "DME", "KZN", 90);

    @BeforeEach
    public void setUp() {
        ticketManager.addTicket(firstTicket);
        ticketManager.addTicket(secondTicket);
        ticketManager.addTicket(thirdTicket);
        ticketManager.addTicket(fourthTicket);

    }


    @Test
    void searchByDirection() {
        Ticket[] actual = ticketManager.searchBy("SVO", "KZN");
        Ticket[] expected = new Ticket[]{firstTicket};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortByPrice() {
        Ticket[] actual = ticketManager.searchBy("DME", "KZN");
        Ticket[] expected = new Ticket[]{fourthTicket, thirdTicket};

        assertArrayEquals(expected, actual);
    }


}
