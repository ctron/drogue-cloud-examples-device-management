import './App.css';

import React, {Component} from 'react';
import {Card, CardBody, Page, PageHeader, PageSection} from "@patternfly/react-core";

import Devices from './components/devices'

export default class App extends Component {
    state = {
        devices: []
    }

    componentDidMount() {
        fetch('/devices')
            .then(res => res.json())
            .then((data) => {
                this.setState({devices: data})
            })
            .catch(console.log)
    }

    loginOk(response) {
        console.log(response)
    }

    loginFailed(response) {
        console.error(response)
    }

    render() {
        const needLogin = this.state.token == null;
        const { devices } = this.state;
        console.log(needLogin);
        const Header = (
            <PageHeader />
        );
        return (
            <React.Fragment>
                <Page
                    header={Header}
                >
                    <PageSection>
                        <Devices devices={devices} />
                    </PageSection>

                </Page>
            </React.Fragment>
        );
    }
}
