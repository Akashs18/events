<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Event"%>
<%@page import="Model.Registration"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
        <title>JSP Page</title>
        <style>
            .container1{
                margin-top: 100px;
                width: 100%;
                padding-left: 100px;
            }
            .container{
                max-width: 1300px;
                margin:auto;
                padding-left: 25px;
                padding-right: 25px;
            }
            /*              body{
                            font-family: 'Poppins', sans-serif;
                            background-color: white;
                        }*/
            /*             .header{
                            background: radial-gradient(#fff,#ffd2d2);
                            background-color: whitesmoke;
                        }*/
            .col-md-7{
                /*                color:#555;*/

            }
            .row{
                display: flex;
                align-items:center;
                flex-wrap: wrap;
                justify-content:space-around;
            }
            .price{
                color:#FE980F;
                font-size:26px;
                font-weight:bold;
                padding-top: 20px;
            }
            /*            .cart{
                            background: #FE980F;
                            color:#FFFFFF;
                            font-size: 15px;
                            margin-left:20px;
                        }*/
            .but{
                display: inline-block;
                background: #ff523b;
                color: #fff;
                padding: 8px 30px;
                margin: 30px 0;
                border-radius: 30px;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="header">

            <div class="container">
                <%@include file="Header.jsp"%>
                <%
                    Registration r = new Registration(session);
                    ArrayList<Event> al = r.get_eventinfo(request.getParameter("event_category"));
                    Iterator<Event> it = al.iterator();
                    while (it.hasNext()) {
                        Event s = it.next();%>
                    <div class="container1">
                        <div class="row"> 
                            <div class="col-md-5">
                                <img  src="images/<%=s.getImage()%>"  class="d-block w-100">
                            </div>
                            <div class="col-md-7">
                                <h2><%=s.getEname()%></h2>
                                <p class="price" >&#8377 <%=s.getCost()%></p>
                                <p><%=s.getDetails()%></p>

                                <% if (session.getAttribute("uname") != null) {%>
                                 <a href="BookingForm.jsp?event_id=<%=s.getEid()%>" class="but">Book Now</a>
                                <% } else {
                                    session.setAttribute("logoutredirect", "Booking.jsp?event_category=" + request.getParameter("event_category"));
                                %>
                                <a href="Login.jsp" class="but">Book Now</a>
                                <% } %>

                            </div>

                        </div>
                    </div>
                <% }%>



            </div>
        </div>
        <br><br><br>
       
    </body>
</html>