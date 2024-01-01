import streamlit as st
import pandas as pd

# In-memory storage for votes and users (not persistent and not secure)
votes = {'Candidate A': 0, 'Candidate B': 0, 'Candidate C': 0}
voted_users = set()

def user_login():
    with st.sidebar:
        st.header("User Login")
        username = st.text_input("Username")
        submit = st.button("Login")
        return submit, username

def main():
    st.title('E-Voting System')
    submit, username = user_login()

    if submit:
        if username and username not in voted_users:
            candidate = st.radio("Choose your candidate", list(votes.keys()))
            if st.button('Vote'):
                if candidate:
                    votes[candidate] += 1
                    voted_users.add(username)
                    st.success(f'You have voted for {candidate}')
                else:
                    st.error("Please select a candidate.")
        elif not username:
            st.error("Please enter a username.")
        else:
            st.error("You have already voted.")

    # Displaying voting results
    st.write('## Voting Results')
    df_votes = pd.DataFrame(votes.items(), columns=['Candidate', 'Votes'])
    st.bar_chart(df_votes.set_index('Candidate'))

if __name__ == "__main__":
    main()
