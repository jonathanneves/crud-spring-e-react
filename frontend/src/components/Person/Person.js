import GlobalStyles from "../../styles/global";
import styled from "styled-components";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect, useState } from "react";
import Form from "./Form";
import Grid from "./Grid";
import axios from "axios";

const Container = styled.div`
  width: 100%;
  max-width: 800px;
  margin-top: 25px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: auto;
  gap: 10px;
`;

const Title = styled.h2``;

function Person() {
  const [users, setUsers] = useState([]);
  const [onEdit, setOnEdit] = useState(null);

  const getUsers = async () => {
    try{
      const res = await axios.get("http://localhost:8800/users");
      setUsers(res.data.sort((a,b)=> (a.name > b.name ? 1 : -1)));
    } catch (error) {
      toast.error(error.response.data);
    }
  };

  useEffect(() => {
    getUsers();
  }, [setUsers]);

  return (
    <>
      <Container>
        <Title style={{paddingTop:'10px'}}>USUÁRIOS</Title>
        <Form onEdit={onEdit} setOnEdit={setOnEdit} getUsers={getUsers} />
        <Grid users={users} setUsers={setUsers} setOnEdit={setOnEdit} />
      </Container>
      <ToastContainer autoClose={3000} position={toast.POSITION.TOP_CENTER} />
      <GlobalStyles/>

    </>
  );
}

export default Person;
