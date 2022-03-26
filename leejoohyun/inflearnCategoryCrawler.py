import requests
from bs4 import BeautifulSoup

url = 'https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B0%B0%EC%B9%98/lecture/91265?tab=curriculum&volume=1.00&speed=1.5'

response = requests.get(url)

if response.status_code == 200:
    html = response.text
    soup = BeautifulSoup(html, 'html.parser')
    ul = soup.select_one('div.curriculum-list')
    majorCategory = ""
    for i in ul:
        for j in i:
            if type(j).__name__ == 'Tag':
                titleList = j.select('div.title')
                if len(titleList) > 0:
                    subcategory = str(titleList[0]).replace("\"", "").replace("<div class=title>","").replace("</div>","")
                    print(" | " + majorCategory + " | " + subcategory + " | 날짜 적기 | 날짜 적기 |")
            if type(j).__name__ == 'NavigableString' and j is not None and j not in '\n':
                majorCategory = j
else:
    print(response.status_code)
