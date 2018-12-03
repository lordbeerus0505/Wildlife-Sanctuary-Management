import flask
import os
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
import mysql.connector




app = flask.Flask(__name__,static_url_path='/static')


mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="abhiram"
)


mycursor = mydb.cursor()

mycursor.execute("USE zoodb")

mycursor.execute("Select * from animal")
a=[]
b=[]
c=[]
d=[]
e=[]
f=[]
g=[]
for x in mycursor:
    # print(x)
    a.append(x[1])
    b.append(x[2])
    c.append(x[3])
    d.append(x[5])
    e.append(x[6])
    f.append(x[7])
x=[]
c=0
mycursor.execute("Select * from habitat")
h=[]
i=[]
j=[]
for x in mycursor:
  g.append(x[1])
  h.append(x[5])
  i.append(x[6])
  j.append(x[7])
@app.route("/")
def home():
    # result = {'count' : str(count.get()), 'uploads' : uploads.get() ,'plate':x}
    result={'name':a,'type':b,'gender':c,'diet_type':d,'diet':e,'status':f}
    return flask.render_template("home.html",result = result)
@app.route("/about")
def about():
    return flask.render_template("about.html")
@app.route("/habitat")
def habitat():
    result={'areaName':g,'vet':h,'size':i,'cap':j}
    return flask.render_template("habitat.html",result = result)

if __name__ == "__main__":

    app.run()
