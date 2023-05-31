# AtonThirdTask

Когда речь идёт о мгновенном доступе к элементу по какому-то ключу(в нашем случае это телефон) на ум сразу приходит словарь. Тут он, в принципе, отлично подходит, так как у нас всего 2 поля - имя и телефон. Также хорошо, что в тз просят реализовать поиск по телефону: можно сразу отбросить головную боль о возможных дубликатах. Если у двух людей с одинаковым именем могут быть разные телефоны, то два одинаковых телефонных номера у них никогда не будет, только если это не один человек с диссоциативным расстройством идентичности. Закончу своё лирическое отступление. Реализуем хранение людей в словаре, где ключом будет являться телефонный номер, а значением - имя человека. Это позволит получать доступ к имени за постоянное время. Памяти займём O(N), где N - количество персон, чьи данные оказались в наших руках. Как попытаться сократить занимаемую память, я так и не смог придумать. Скажу только, что при необходимости строковые переменные в Java можно кешировать добавлением в строковый пул. Это чуть уменьшит занимаемую память, особенно если нам как хакерам повезло, и в полученных данных все люди имеют одинаковое имя.  

По реализации:  
В контроллере описал 2 метода, которые ловят get и post запросы. В задании точно не указано, как именно мы получаем данные, поэтому я дал волю фантазии и вырученные данные приходят к нам json-ом в post-запросе. Json-файл спринг десериализует в лист и вызывает метод getSuperSecretData, который в свою очередь вызывает метод объекта DAO, где непосредственно и хранится словарь. В классе DAO метод addSecretData инициализирует словарь, если нужно, и добавляет в него данные.  
Чтобы узнать имя человека по номеру телефона, нужно в поле ввода ввести номер телефона, и если он хранится в словаре, то после нажатия кнопки оно появится, иначе появится сообщение, что такого имени нет. Нажатие на кнопку заберет номер телефона из поля ввода и сформирует get-запрос, который спринг направит в метод getName в контроллере. Контроллер в свою очередь вызовет метод getNameOfPerson из DAO, который вернёт либо имя пользователя, либо сообщение о том, что такого человека нет.
