package dev.hemil.bookmyshowapplication.design;

public class DesignBookTicketUseCase {

    public static void main(String[] args){
        /* This is the full insight about how a ticket booking process goes on any of the
        online platform work.

        To book a ticket on an online platform, first user logins to the platform and
        then searches for the city and available show and then selects a theater of their
        choice and then moves on select the seat, now comes the core part of managing the
        users accordingly when they have selected the seat which might be common in between.

        So when a seat is there in common amongst the users, only one user can book the
        seat so to handle this scenario, when a user clicks on book seats, there is a small
        pause or a confirmation page in before the final payment page, and that confirmation
        page checks for the availability of the requested seat by user and if that seat is
        already booked by some other user while booking, then it shows this user as something
        is not right and then the user needs to follow the booking process again, and this
        flow ensures that there can be no clash amongst users booking common seats.

        To achieve this kind of flow, there are multiple approaches, and the first one for it is

        1) Approach - 1
        Whatever we are checking for the seat status, is coming from the database, and we want
        that a seat belongs to a particular user so while a booking process is under process,
        those seats would be set as blocked till that user lands the payment page, and for
        this database operation we need to start a transaction and then set ISOLATION level
        as SERIALIZABLE and as soon as the payment is completed, close the transaction, if
        payment is failed, or time is up, or user closes the page and then close the
        transaction.
        This seems perfect, but there is a minor flaw here, we are starting the transaction
        and acquiring the lock on the seats as user selects them and releasing the lock when
        the timer ends or user makes the payment for those selected seats, we release the
        lock at the end of the timer in some cases, so this is a disadvantage as the
        transaction will be running for a longer period of time and in that duration, none
        of the operation will be read the seat related data.

        2) Approach - 2
        We will initiate transaction at the end of timer or payment completes, now this sounds
        somewhat ridiculous, but it will get cleared now. Let's consider the scenario that we
        are trying to solve here, two users U1 and U2 are booking seats at the same time,
        user U1 selected seats (1, 2) and user U2 wants to select seats (2, 3) now as user U1
        selected those seats, user U2 will find the status of those seats as blocked as we
        initiated a transaction and closed it after changing the status of those seats to
        blocked so that's why user U2 was able to check the status and moved on to book some
        other seats. So the high-level idea here is that we don't need to acquire lock for
        longer duration of time, instead of carrying out the task and release the locks.

        Now as we are not holding transaction for longer duration, so when a user will head to
        the payment page with some selected seats, a confirmation page or a small pause will
        be triggered to check whether the selected seats are still available and if then
        user will be taken to payment page and then after completion of the payments, a
        transaction will be initiated and that will change the status of seats to booked, and
        if the seats are found unavailable while confirming, the user will be notified by
        something is not right and will be taken back to the screen's booking page.

        The approach that we followed is called "Soft Locking"
        */
    }
}
