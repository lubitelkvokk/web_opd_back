CREATE TABLE profit.experts (
    id SERIAL primary key,
    identifier VARCHAR(63),
    fio VARCHAR(127) ,
    relevance DOUBLE
);
CREATE TABLE profit.professions(
    id SERIAL PRIMARY KEY,
    name VARCHAR(63),
    description TEXT
);
CREATE TABLE profit.choice_of_professions(
    id SERIAL PRIMARY KEY,
    expert_id VARCHAR(63) REFERENCES experts(id),
    profession_id INTEGER REFERENCES professions(id)
);
CREATE TABLE profit.competencies(
    id SERIAL PRIMARY KEY,
    name TEXT
);
CREATE TABLE profit.evaluation(
    id SERIAL PRIMARY KEY,
    expert_id VARCHAR(63) REFERENCES experts(id),
    profession_id INTEGER REFERENCES professions(id),
    competencies_id INTEGER REFERENCES competencies(id)
);
DROP TABLE evaluation;
DROP TABLE choice_of_professions;
DROP TABLE competencies;

INSERT INTO competencies(name) values ('Готовность к защите Родины с оружием в руках');
INSERT INTO competencies(name) values ('Военно-профессиональная направленность');
INSERT INTO competencies(name) values ('Прямые внутренние мотивы военно-профессиональной деятельности');
INSERT INTO professions(name, description) values ('Backend-Разработчик', 'Бэкенд-разработчик создаёт компоненты и функции, которые доступны пользователю приложения или сайта через интерфейс. Проще говоря, бэкендеры — это программисты, которые разрабатывают всё то, что не видит и напрямую не трогает пользователь. То есть красивая форма ввода данных или корзина интернет-магазина — это фронтенд, а хранение данных в СУБД, связка полей формы регистрации и корзины, интеграция с платёжным шлюзом, автоматические письма, подгрузка и обновление контента — это всё бэкенд.');
INSERT INTO professions(name, description) values ('Frontend-Разработчик', 'Фронтенд-разработчик — это специалист, который создает пользовательские интерфейсы. Он отвечает за всю внешнюю часть сайта или приложения, с которой взаимодействуют люди: меню, карточки товаров в интернет-магазине, кнопки, формы обратной связи. Благодаря качественной работе фронтенд-разработчика появляются быстрые и удобные сайты.');
INSERT INTO professions(name, description) values ('HR-менеджер', 'HR-менеджер — это сотрудник по управлению персоналом. Аббревиатура HR стала использоваться в казахском языке относительно недавно. С английского — HR (читаем как «эйч ар») — human resources — дословно переводится как ‘человеческие ресурсы’. Этим словом обозначается весь персонал, который есть в распоряжении конкретной компании.');

INSERT INTO experts(id, fio, relevance) values ('bZ.rmYORhL\8"O^Wc;T6C\,1Jm/8ZKJZT2,J";|Kha.oN_DVuq*>yua;U<u3P#S', 'Андреев Степан Сергеевич', 0.87);
DELETE FROM professions where id > 3;