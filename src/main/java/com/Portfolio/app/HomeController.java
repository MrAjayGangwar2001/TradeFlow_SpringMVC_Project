package com.Portfolio.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
                <html>
                    <head>
                    <title>TradeFlow App</title>
                    <style>
                        body {
                        background: linear-gradient(120deg, #1a2a6c, #b21f1f, #fdbb2d);
                        background-size: 600% 600%;
                        animation: gradientBG 8s ease infinite;
                        color: #fff;
                        font-family: "Poppins", sans-serif;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                        height: 100vh;
                        margin: 0;
                        text-align: center;
                        }

                        @keyframes gradientBG {
                        0% {
                        background-position: 0% 50%;
                        }

                        50% {
                        background-position: 100% 50%;
                        }

                        100% {
                        background-position: 0% 50%;
                        }
                    }

                        h1 {
                        font-size: 3em;
                        margin: 0;
                        }

                        p {
                        font-size: 1.2em;
                        margin-top: 10px;
                        opacity: 0.5;
                        }

                        .status {
                        margin-top: 30px;
                        background: rgba(255, 255, 255, 0.2);
                        display: inline-block;
                        padding: 10px 25px;
                        border-radius: 10px;
                        }
                    </style>
                </head>

                <body>
                    <h1>🚀 TradeFlow Project is Live!</h1>
                    <p>Server is running smoothly on port <b>2907</b></p>
                    <p>You are on Home Page.</p>
                    <p>This project is Only Backend Part</p>
                    <div class="status">✅ Status: <b>UP</b></div>
                </body>
            </html>

        """;
    }

    
    @GetMapping("/user")
    public String User() {
        return """
                <html>
                    <head>
                    <title>TradeFlow App</title>
                    <style>
                        body {
                        background: linear-gradient(120deg, #1a2a6c, #b21f1f, #fdbb2d);
                        background-size: 600% 600%;
                        animation: gradientBG 8s ease infinite;
                        color: #fff;
                        font-family: "Poppins", sans-serif;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                        height: 100vh;
                        margin: 0;
                        text-align: center;
                        }

                        @keyframes gradientBG {
                        0% {
                        background-position: 0% 50%;
                        }

                        50% {
                        background-position: 100% 50%;
                        }

                        100% {
                        background-position: 0% 50%;
                        }
                    }

                        h1 {
                        font-size: 3em;
                        margin: 0;
                        }

                        p {
                        font-size: 1.2em;
                        margin-top: 10px;
                        opacity: 0.5;
                        }

                        .status {
                        margin-top: 30px;
                        background: rgba(255, 255, 255, 0.2);
                        display: inline-block;
                        padding: 10px 25px;
                        border-radius: 10px;
                        }
                    </style>
                </head>

                <body>
                    <h1>👥 Hello! User You are on User Page.</h1>
                    <p>Server is running.</p>
                    <div class="status">✅ Status: <b>UP</b></div>
                </body>
            </html>

        """;
    }

    
    @GetMapping("/admin")
    public String Admin() {
        return """
                <html>
                    <head>
                    <title>TradeFlow App</title>
                    <style>
                        body {
                        background: linear-gradient(120deg, #1a2a6c, #b21f1f, #fdbb2d);
                        background-size: 600% 600%;
                        animation: gradientBG 8s ease infinite;
                        color: #fff;
                        font-family: "Poppins", sans-serif;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                        height: 100vh;
                        margin: 0;
                        text-align: center;
                        }

                        @keyframes gradientBG {
                        0% {
                        background-position: 0% 50%;
                        }

                        50% {
                        background-position: 100% 50%;
                        }

                        100% {
                        background-position: 0% 50%;
                        }
                    }

                        h1 {
                        font-size: 3em;
                        margin: 0;
                        }

                        p {
                        font-size: 1.2em;
                        margin-top: 10px;
                        opacity: 0.5;
                        }

                        .status {
                        margin-top: 30px;
                        background: rgba(255, 255, 255, 0.2);
                        display: inline-block;
                        padding: 10px 25px;
                        border-radius: 10px;
                        }
                    </style>
                </head>

                <body>
                    <h1>👤 Hello! Admin Ajay Gangwar.</h1>
                    <p>You are on ADMIN Page.</p>
                    <div class="status">✅ Status: <b>UP</b></div>
                </body>
            </html>

        """;
    }

    

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // ye login.html file ko return karega (templates folder se)
    }
}
