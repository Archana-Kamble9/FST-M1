import pandas
from pandas import ExcelWriter

data = {
    'FirstName': ["Abc", "Xyz", "Aqw"],
    'LastName': ["A", "B", "C"],
    'Email': ["a@a.com", "b@b.com", "c@c.com"],
    'PhoneNumber': ["123", "1245", "345"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)

writer = ExcelWriter('sample2.xlsx')
dataframe.to_excel(writer, 'Sheet1', index=False)

writer._save()