//var stn="";
var name1,email,phone,add,uname,password;
function validateForm()
{
    
    validateName();
    validateEmail();
    validatePhone();
    validateAddreess();
    validateUsername();
    validatePassword();
    
    if( name1==true && email==true && phone==true && add==true && uname==true && password==true)
    {
	return true;
    }
    else
    {
	//alert(stn);
	//stn="";
	return false;
    }
				
}

function validateName()
{
    var x = document.getElementById("name_reg").value;
    if(x=="")
    {
        //stn=stn+"Empty name Field\n";
        document.getElementById("name_reg").style.border = "1px solid #FF0000";
        name1=false;
    }
    else
    {
        document.getElementById("name_reg").style.border = "1px solid #00FF00";
        name1=true;
    }
}
function validateEmail()
{
    var x = document.getElementById("email_reg").value;

    if(x=="")
    {
        //stn=stn+"Empty Email address\n";
        document.getElementById("email_reg").style.border = "1px solid #FF0000";
        email=false;
    }
    else
    { 
         var atpos = x.indexOf("@");
        var dotpos = x.lastIndexOf(".");
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) 
        {
            //stn=stn+"Not a valid e-mail address\n";
            document.getElementById("email_reg").style.border = "1px solid #FF0000";
            email=false;
        }
        else
        {
            document.getElementById("email_reg").style.border = "1px solid #00FF00";
            email=true;
        }
    }
}
function validatePhone()
    {
	var x = document.getElementById("mobile_reg").value;
        if(x=="")
        {
            //stn=stn+"Empty phone no. \n";
            document.getElementById("mobile_reg").style.border = "1px solid #FF0000";
            phone=false;
        }
        else
        {
            var l=x.length;
            if(l<10)
                {
                    //stn=stn+"Not a valid phone no.\n";
                    document.getElementById("mobile_reg").style.border = "1px solid #FF0000";
                    phone=false;
                }
            else
            {
                document.getElementById("mobile_reg").style.border = "1px solid #00FF00";
                phone=true;
            }
        }
    }
function validateAddreess()
{
    var x = document.getElementById("address_reg").value;
        if(x=="")
        {
          // stn=stn+"Empty address. \n";
           document.getElementById("address_reg").style.border = "1px solid #FF0000";
           add=false;
        }
        else
        {
            document.getElementById("address_reg").style.border = "1px solid #00FF00";
            add=true;
        }
}
function validateUsername()
{
    var x = document.getElementById("username_reg").value;
        if(x=="")
        {
           // stn=stn+"Empty username \n";
            document.getElementById("username_reg").style.border = "1px solid #FF0000";
            uname=false;
        }
        else
        {
            document.getElementById("username_reg").style.border = "1px solid #00FF00";
            uname=true;
        }
}

function validatePassword()
{
    var x = document.getElementById("password_reg").value;
        if(x=="")
        {
           // stn=stn+"Empty password \n";
            document.getElementById("password_reg").style.border = "1px solid #FF0000";
            password=false;
        }
        else
        {
            document.getElementById("password_reg").style.border = "1px solid #00FF00";
            password=true;
        }
}
 

var cuname,cpassword;
function validateClient()
{
    cuname=false;
    cpassword=false;
    username();
    password();
    if(cuname==true && cpassword==true)
    {
	return true;
    }
    else
    {
	//alert(stn);
	stn="";
	return false;
    }
				
}
function username()
{
    var x = document.getElementById("username").value;
        if(x=="")
        {
           // stn=stn+"Empty username \n";
            //document.getElementById("username_login").style.border = "1px solid #FF0000";
            document.getElementById("username").setCustomValidity('Enter Your Id');
            cuname=false;
        }
        else
        {
           //document.getElementById("username_login").style.border = "1px solid #00FF00";
            cuname=true;
        }
}
function password()
{
    var x = document.getElementById("password").value;
        if(x=="")
        {
           // stn=stn+"Empty password \n";
            //document.getElementById("password").style.border = "1px solid #FF0000";
            document.getElementById("password").setCustomValidity('Enter Your Password');
            cpassword=false;
        }
        else
        {
            //document.getElementById("password_login").style.border = "1px solid #00FF00";
            cpassword=true;
        }
}
   
 
    
