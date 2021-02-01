# Passenger Rail Car Pneumatic Brake Testing App- Android App

<img src="/readme/via_logo.png" align="left" width="200" hspace="10" vspace="10">

Via Passenger Rail Car Pneumatic Brake Testing app is an app designed to allow via employees to conduct train pressure test cases on a tablet device. The tablet application is one of the four sub-components (android application, server, wpsu, mechanical basestation) which combine to form the pneumatic brake testing system and perform tests on rail cars.

## About

This project is part of GENE404 course in University of Waterloo which is completed in a group of 4 in Winter 2020. This app and the rest of the systems has been demoed and sended to Via Ottawa for future usage. The following graph shows how all the components in the system work together and conduct tests on train brakes.

The mobile interface will mainly wirelessly communicate with the basestation's server. The basestation is physically connected to the brake pipe control and the main reservoir control of the train, while wirelessly connected to the WPSU installed in the test ports which will provides the pressor sensor readings. Through the use of api calls, the app will send and receieved data from the basestation based on the user requests. This allows users to wirelessly read pressure sensors reading, view data from previously conducted tests, run new tests and manual control over the basestation without needing to physically be next to the train brakes.

[<img src="/readme/system_graph.png" align="center"
width="450"
    hspace="10" vspace="10">](/readme/system_graph.png)

## Features

This android app will allow you:

- View the previous tests conducted
- Run brake pressure tests
- Run tests via test flow
- Manually control on the basestation
- View test result logs

## Demo

The following is a demo video for this app.
https://vimeo.com/506933869

## Screenshots

[<img src="/readme/dashboard.png" align="left"
width="350"
    hspace="10" vspace="10">](/readme/dashboard.png)
[<img src="/readme/nav.png" align="center"
width="350"
    hspace="10" vspace="10">](/readme/nav.png)
    
[<img src="/readme/run_test.png" align="left"
width="350"
    hspace="10" vspace="10">](/readme/run_test.png)

[<img src="/readme/view_test.png" align="center"
width="350"
    hspace="10" vspace="10">](/readme/view_test.png)
    
[<img src="/readme/manual_test.png" align="left"
width="350"
    hspace="10" vspace="10">](/readme/manual_test.png)
[<img src="/readme/test_log.png" align="center"
width="350"
    hspace="10" vspace="10">](/readme/test_log.png)

## The Complete System

The following photos shows the rest of the sub-components completed by the team which together forms the passenger rail car pneumatic brake system. The photo on the left shows the physical basestation and the photo on the right shows a WPSU.

[<img src="/readme/pneumatic_circuit.png" align="left"
width="530"
    hspace="10" vspace="10">](/readme/pneumatic_circuit.png)
[<img src="/readme/wpsu.png" align="center"
width="300"
    hspace="10" vspace="10">](/readme/wpsu.png)

## License

This application is released under GNU GPLv3 (see [LICENSE](LICENSE)).
Some of the used libraries are released under different licenses.
