<%-- 
    Document   : index
    Created on : Nov 6, 2021, 11:46:11 PM
    Author     : ub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>EX8_2</h1>
        <form action="insertServlet" method="POST">
            Insert student
            <br>
            ID:
            <br>
            <input type="text" name="id" value="" size="30" />
            <br>
            NAME:
            <br>
            <input type="text" name="name" value="" size="30" />
            <br>
            GPA:
            <br>
            <input type="text" name="gpa" value="" size="30" />
            <br>
            <input type="submit" value="insert!" />
        </form>
        <br>
        <form action="deleteServlet" method="POST">
            Delete student
            <br>
            ID:
            <br>
            <input type="text" name="id" value="" size="30" />
            <br>
            <input type="submit" value="delete!" />
        </form>
        <br>
        
        <form action="updateServlet" method="POST">
            Update student
            <br>
            ID:
            <br>
            <input type="text" name="id" value="" size="30" />
            <br>
            NAME:
            <br>
            <input type="text" name="name" value="" size="30" />
            <br>
            GPA:
            <br>
            <input type="text" name="gpa" value="" size="30" />
            <br>
            <input type="submit" value="update!" />
        </form>
    </body>
</html>
