package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.*;
import dev.abhishek.bookmyshow.entity.constants.SeatType;
import dev.abhishek.bookmyshow.entity.constants.ShowSeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class IntializationServiceImpl implements IntializationService {
    @Autowired
    private  UserService userService;
    @Autowired
    private  MovieService movieService;
    @Autowired
    private  TheatreService theatreService;
    @Autowired
    private  ShowService showService;
    @Autowired
    private  ShowSeatService showSeatService;
    @Autowired
    private  TicketService ticketService;
    @Autowired
    private  AuditoriumService auditoriumService;
    @Autowired
    private  CityService cityService;
    @Autowired
    private SeatService seatService;

    @Override
    public void run(String... args) throws Exception {
      if(cityService.getAllCities().isEmpty()){
          demoDataIntialization();
      }
      else {
          System.out.println("\n═══════════════════════════════════════════════════════════════════════════");
          System.out.println("DUMMY DATA ALREADY EXISTS - SKIPPING INITIALIZATION");
          System.out.println("═══════════════════════════════════════════════════════════════════════════\n");
      }
    }

    @Override
    @Transactional
    public void demoDataIntialization(){
        //city add
        City Delhi = createCity();
        //theatre add
        List<Theatre>theatres = createTheatres(Delhi);
        //auditorium //seat add
        for(Theatre theatre : theatres){
           createAuditoriums(theatre);
        }
//movie add
        List<Movie>movies = createMovies();
        //show add //show seat add
        createShows(theatres,movies);

        //user add
        createUsers();


    }

    @Override
    public City createCity(){
        City city = new City();
        city.setCityName("Delhi");
        return cityService.saveCity(city);
    }

    @Override
    public List<Theatre> createTheatres(City city)
    {
      String[] theatreNames = {"PVR Anupam", "PVR Saket", "PVR Vasant Kunj", "PVR Rajouri Garden", "PVR Rohini"};
      String[] theatreAddress = {"Connaught Place, Delhi", "Saket, Delhi", "Vasant Kunj, Delhi", "Rajouri Garden, Delhi", "Rohini, Delhi"};
      List<Theatre> theatres = new ArrayList<Theatre>();
      for (int i=0;i<theatreNames.length;i++)
      {
          Theatre theatre = new Theatre();
          theatre.setTheatreName(theatreNames[i]);
          theatre.setAddress(theatreAddress[i]);
          theatre.setCity(city);
          theatres.add(theatreService.saveTheatre(theatre));
      }
        city.setTheatres(theatres);
        cityService.saveCity(city);
        return theatres;
    }
    @Override
    public void createAuditoriums(Theatre theatre)
    {
        String[] auditoriumNames = {"Auditorium 1", "Auditorium 2", "Auditorium 3"};
        List<Auditorium> auditoriums = new ArrayList<>();
        for (int i=0;i<auditoriumNames.length;i++)
        {
            Auditorium auditorium = new Auditorium();
            auditorium.setAuditoriumName(auditoriumNames[i]);
            auditorium.setTheatre(theatre);
            Auditorium savedAuditorium = auditoriumService.saveAuditorium(auditorium);
            createSeats(savedAuditorium);
            auditoriums.add(savedAuditorium);
        }
       theatre.setAuditoriums(auditoriums);
       theatreService.saveTheatre(theatre);
    }

    @Override
    public void createSeats(Auditorium auditorium)
    {
        List<Seat> seats = new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            for(int j=1;j<=10;j++)
            {
                Seat seat = new Seat();
                seat.setRow(i);
                seat.setSeatColumn(j);
                seat.setSeatNumber(String.valueOf(i+j));
                if(i<=2)
                    seat.setSeatType(SeatType.GOLD);
                else if(i>2 && i<=5)
                    seat.setSeatType(SeatType.PLATINUM);
                else
                    seat.setSeatType(SeatType.SILVER);
                seat = seatService.saveSeat(seat);
                seats.add(seat);
            }

        }
        auditorium.setSeats(seats);
        auditoriumService.saveAuditorium(auditorium);

    }

    @Override
    public List<Movie> createMovies()
        {
            String[] movieNames = {
                "Article 370", "Fighter", "Bhaiyya Ji", "Crew", "Khel Khel Mein",
                "Jawan", "Dunki", "Pathaan", "Drishyam 2", "Animal",
                "Fukrey 3", "Chandrayaan", "Shaitaan", "Bade Miyan Chote Miyan", "Sarfira",
                "Bhool Bhulaiyaa 3", "Kanguva", "Khiladi", "Badhaai Do", "Notification"
            };
            String[] genres = {
                "Drama", "Action", "Comedy", "Comedy", "Comedy",
                "Action", "Comedy-Drama", "Action", "Thriller", "Action-Drama",
                "Comedy", "Documentary", "Thriller", "Action-Comedy", "Drama",
                "Horror-Comedy", "Action-Thriller", "Thriller", "Comedy-Drama", "Romance"
            };
            int[] durations = {
                138, 165, 110, 125, 130,
                160, 150, 155, 162, 180,
                140, 135, 125, 145, 148,
                146, 156, 142, 122, 138
            };
            String[] releaseDates = {
                "2024-02-23", "2024-01-25", "2024-03-08", "2024-03-29", "2024-09-13",
                "2023-09-07", "2023-12-25", "2023-01-25", "2022-11-18", "2023-12-01",
                "2023-09-22", "2024-01-12", "2024-08-16", "2024-04-19", "2024-07-12",
                "2024-11-01", "2024-10-12", "2024-03-22", "2024-02-02", "2024-05-10"
            };
            String[] aboutDescriptions = {
                "A gripping political drama about a landmark constitutional article",
                "An action-packed thriller featuring aerial combat and intense sequences",
                "A comedy film with witty dialogues and entertaining performances",
                "A comedy film about a group of friends embarking on an adventure",
                "A light-hearted comedy exploring friendship and life's simple pleasures",
                "An action thriller with stunning action sequences and emotional depth",
                "A heartwarming comedy-drama about family and relationships",
                "A high-octane action spy thriller with international intrigue",
                "A gripping psychological thriller full of suspense and twists",
                "An intense action-drama exploring the dark side of ambition",
                "A hilarious comedy sequel with slapstick humor and witty jokes",
                "A fascinating documentary about space exploration and discovery",
                "A thrilling supernatural drama with horror and suspenseful elements",
                "An action-comedy featuring larger-than-life characters and fun sequences",
                "An emotional drama about perseverance and the human spirit",
                "A hilarious horror-comedy that blends scares with laughter",
                "An action-packed thriller with stunning fight choreography",
                "A suspenseful thriller with mind-bending plot twists",
                "A feel-good comedy-drama celebrating diversity and acceptance",
                "A romantic drama exploring the power of love and connection"
            };
            String[] ratings = {
                "8.2/10", "8.5/10", "7.8/10", "7.5/10", "7.9/10",
                "8.7/10", "8.1/10", "8.4/10", "8.3/10", "8.9/10",
                "7.6/10", "8.0/10", "7.7/10", "7.4/10", "7.3/10",
                "8.6/10", "8.2/10", "7.9/10", "8.1/10", "7.8/10"
            };
            String[] votes = {
                "45230", "52180", "38920", "41670", "39450",
                "68920", "44780", "59300", "52140", "71340",
                "42560", "28960", "35670", "31240", "29870",
                "58340", "48210", "40120", "46890", "33540"
            };

            List<Movie> movies = new ArrayList<>();
            for (int i = 0; i < movieNames.length; i++) {
                Movie movie = new Movie();
                movie.setMovieName(movieNames[i]);
                movie.setGenre(genres[i]);
                movie.setDurationInMinutes(durations[i]);
                movie.setReleaseDate(releaseDates[i]);
                movie.setAbout(aboutDescriptions[i]);
                movie.setRating(ratings[i]);
                movie.setVotes(votes[i]);
                movies.add(movieService.saveMovie(movie));
            }
            return movies;
        }

        @Override
        public void createShows(List<Theatre> theatres, List<Movie> movies)
        {
            LocalDateTime startDate = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0);
            for(int dayOffSet = 0; dayOffSet < 7; dayOffSet++)
            {
                LocalDateTime showStartTime = startDate.plusDays(dayOffSet);
                for(Theatre theatre : theatres)
                {   List<Auditorium> auditoriums = theatre.getAuditoriums();
                    for(Auditorium auditorium : auditoriums)
                    {
                       for(int slot = 0; slot < 3; slot++)
                       {
                           Show show = new Show();
                           show.setAuditorium(auditorium);
                           show.setMovie(movies.get((int)(Math.random() * movies.size())));
                           // Set show times: 10:00 AM, 2:00 PM, 6:30 PM
                           int hour = (slot == 0) ? 10 : (slot == 1) ? 14 : 18;
                           int minute = (slot == 2) ? 30 : 0;

                           LocalDateTime startTime = showStartTime.withHour(hour).withMinute(minute);
                           LocalDateTime endTime = startTime.plusHours(2).plusMinutes(30); // 2.5 hour duration

                           show.setStartTime(startTime);
                           show.setEndTime(endTime);
                           Show savedShow = showService.saveShow(show);
                           createShowSeats(savedShow, auditorium);

                       }
                    }
                }
            }
        }

    @Override
    public void createShowSeats(Show show, Auditorium auditorium) {
        List<Seat> auditoriumSeats = auditorium.getSeats();
        for (Seat seat : auditoriumSeats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setShow(show);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);

            // Set pricing based on seat type
            if (seat.getSeatType() == SeatType.GOLD) {
                showSeat.setPrice(250);
            } else {
                showSeat.setPrice(150);
            }
            showSeatService.save(showSeat);
        }
    }

    @Override
    public void createUsers() {
        String[] userNames = {"Rajesh Kumar", "Priya Singh", "Amit Patel", "Deepika Nair", "Arjun Verma"};
        String[] userEmails = {
                "rajesh.kumar@email.com",
                "priya.singh@email.com",
                "amit.patel@email.com",
                "deepika.nair@email.com",
                "arjun.verma@email.com"
        };

        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername(userNames[i]);
            user.setEmail(userEmails[i]);
            user.setPassword("password123"); // Default password for testing
            userService.save(user);
        }
    }
}
