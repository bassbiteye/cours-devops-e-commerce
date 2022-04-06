<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="public/connexion/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="public/connexion/css/util.css">
    <link rel="stylesheet" type="text/css" href="public/connexion/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100" style="background-image: url('public/connexion/images/bg-01.jpg');">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form class="login100-form validate-form" method="post" action="Login">
					<span class="login100-form-title p-b-49">
						Connexion
					</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
                    <span class="label-input100">Email</span>
                    <input class="input100" type="email" name="email" placeholder="Saisir  votre email">
                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Mot de passe">
                    <span class="label-input100">Password</span>
                    <input class="input100" type="password" name="pass" placeholder="Saisir votre  mot de passe">
                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                </div>

                <div class="text-right p-t-8 p-b-31">
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Connecter
                        </button>
                    </div>
                </div>

                <div class="flex-col-c p-t-30">
						<span class="txt1 p-b-17">
							Or Sign Up Using
						</span>

                    <a href="#" class="txt2">
                        Sign Up
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="public/connexion/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="public/connexion/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="public/connexion/vendor/bootstrap/js/popper.js"></script>
<script src="public/connexion/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="public/connexion/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="public/connexion/vendor/daterangepicker/moment.min.js"></script>
<script src="public/connexion/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="public/connexion/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="public/connexion/js/main.js"></script>

</body>
</html>