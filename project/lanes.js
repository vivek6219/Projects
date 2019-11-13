
var xmlHttp = createXmlHttpRequestObj();

function createXmlHttpRequestObj()
{
	var xmlHttp;
	if(window.createXMLHttpRequest)
	{
		xmlHttp = new XMLHttpRequest();
	}

	return xmlHttp;
}
function process()
{
	if(xmlHttp){
		try{
			xmlHttp.open("GET","data.txt", true);
			xmlHttp.onreadystatechange=serverResponse;
			xmlHttp.send(null);
		}
		catch(e)
		{
			alert(e.toString());
		}
	}
}

function serverResponse()
{
	test = document.getElementById('test');
	if(xmlHttp.readyState==1)
	{
		test.innerHTML+="Status 1: server connection established";
		}
	else if(xmlHttp.readyState==4)
		if(xmlHttp.status = 200)
		{
			try{
				text=xmlHttp.responseText;
				test.innerHTML+="resoponse ready";
				test.innerHTML+=text;
			}
			catch(e){
				alert(e.toString());
			}
		}
		else
		{
			alert(xmlHttp.statusText);
		}
	}
