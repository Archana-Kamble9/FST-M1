import pandas

data = {
    "Usernames": ["A", "B", "C"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)

dataframe.to_csv("sample.csv", index=False)